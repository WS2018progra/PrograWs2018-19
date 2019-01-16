-- given
spaces :: Int -> String
spaces 0 = ""
spaces n = " " ++ spaces (n-1)

dashes :: Int -> String
dashes 0 = ""
dashes n = "-" ++ dashes (n-1)

zipOutput :: [String] -> Int -> [String] -> Int -> [String]
zipOutput [] _ [] _           = []
zipOutput (x:xs) n1 [] n2     = (x ++ " " ++ (spaces n2)):(zipOutput xs n1 [] n2)
zipOutput [] n1 (y:ys) n2     = ((spaces n1) ++ " " ++ y):(zipOutput [] n1 ys n2)
zipOutput (x:xs) n1 (y:ys) n2 = (x ++ " " ++ y):(zipOutput xs n1 ys n2)

data Output = Output [String] Int Int

display :: Rosebush -> Output
display Rose = Output ["*"] 1 1
display Cut = Output ["X"] 1 1
display (Stalk p) = Output (line:o) i n
               where line = (spaces (i-1)) ++ "|" ++ (spaces (n-i))
                     Output o i n = display p
display (Fork p1 p2) = Output (line:(zipOutput o1 n1 o2 n2)) (n1+1) (n1+1+n2)
               where line = (spaces (i1-1)) ++ "+" ++ (dashes (n1-i1)) ++ "+"
                         ++ (dashes (i2-1)) ++ "+" ++ (spaces (n2-i2))
                     Output o1 i1 n1 = display p1
                     Output o2 i2 n2 = display p2

concatenate :: [String] -> String
concatenate []     = ""
concatenate (x:xs) = (concatenate xs) ++ x ++ "\n"

showMe rosebush = putStr (concatenate o)
                  where Output o _ _ = display rosebush
				  
data Rosebush = Rose | Cut | Stalk(Rosebush) | Fork(Rosebush)(Rosebush) deriving Show

generate::Rosebush
generate = Stalk(Fork
			       (Stalk
				      (Fork
					     (Stalk(generate))
					     (Stalk(Rose))
					   )
					)
					(Stalk
					   (Stalk
					      (Fork
						     (Stalk(Rose))
							 (Stalk
							    (Stalk
								   (Stalk(generate))
								)
							  )
						    )
						)
					)
				    
				)
				
				
cut::Int->Rosebush->Rosebush
cut 0 _        = Cut
cut a (Stalk(b)) = Stalk(cut (a-1) b)
cut a (Fork b c) = Fork(cut(a-1)(b))(cut(a-1)(c))
cut _ b = b
