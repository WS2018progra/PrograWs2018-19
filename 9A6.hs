data Optional a = Empty | Present a deriving Show


--a)

mapOptional::(a->b)->Optional a->Optional b
mapOptional f Empty = Empty
mapOptional f (Present a) = Present(f a)

--b)

filterOptional::(a->Bool)->Optional a->Optional a
filterOptional f Empty = Empty
filterOptional f (Present a) | (f a) == True = (Present a)
                             | otherwise     = Empty
							 
--c)

foldOptional::(a->b)->b->Optional a->b
foldOptional _ b Empty = b
foldOptional f b (Present a) = f a

--d)

data Product = Article String Int deriving Show

isHumanEatable::Product->Bool
isHumanEatable (Article "Dog Food" b) = False
isHumanEatable a = True

adjustPrice::Product->Product
adjustPrice (Article a b) |(b<1000)= (Article a (b*2))
                          | otherwise = (Article a b)
						  
stringify::Product->String
stringify (Article a b) = ("The Article named "++a++" costs "++show b++" Cent") 

--e)

filterHumanEatable::Product->Optional Product
filterHumanEatable (Article a b)= (filterOptional isHumanEatable (Present(Article a b)))

adjustPriceO::Optional Product->Optional Product
adjustPriceO  (Present(Article a b))=(mapOptional adjustPrice (Present(Article a b)))
adjustPriceO Empty = Empty

stringifyO::Optional Product->String
stringifyO (Present(Article a b))= (foldOptional stringify "This Article is unavailable" (Present(Article a b)))
stringifyO Empty = "This Article is unavailable"


toPriceTag::Product->String
toPriceTag (Article a b) = stringifyO((adjustPriceO(filterHumanEatable (Article a b))))









