fib n | n == 0 = 0
	  | n == 1 = 1
	  | otherwise = fib(n-1) + fib (n-2)

pow :: Int -> Int -> Int
pow a b | b == 0 = 1
		| b < 0 = 0
		| otherwise = a * pow a (b-1)

		
isDiv :: Int -> Int -> Bool
isDiv a b | b == 0 = False
		| a == 0 = True
		|  hasRest a b == 0 = True
		| otherwise = False

hasRest :: Int -> Int -> Int
hasRest a b |(a-b)<0 = 1
			| (a-b)==0 = 0
			|otherwise = hasRest (a-b) b  



sumUp [] = 0
sumUp (x:xs) | xs == [] = x
		     | otherwise = x + sumUp xs 
			 
multLists :: [Int] -> [Int] -> [Int]
multLists [] ys = []
multLists xs [] = []
multLists (x:xs) (y:ys) |xs == [] = (x*y:[])
				        |ys == [] = (x*y:[])
				        |otherwise = ((x*y):(multLists xs ys))

 --binRep :: Int -> [Int]
binRep n | n == 0 = [0]--(0,0)
		 | n == 1 = [1]--(0,1)
		 |hasRest n 2 == 0 = binRep (div n 2)++[0] --(0:binRep (div n 2))
		 |hasRest n 2 == 1 = binRep (div n 2)++[1] --(1:binRep (div n 2))
		 |otherwise = []
					   