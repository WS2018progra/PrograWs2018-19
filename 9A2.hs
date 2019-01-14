data VariableName = X | Y deriving Show

getValue::VariableName->Int
getValue X = 5 
getValue Y = 13

data Expression = Constant Int | Variable(VariableName) | Add Expression Expression| Multiply Expression Expression deriving Show

evaluate :: Expression->Int
evaluate (Constant a)  = a
evaluate (Variable a)  = (getValue a)
evaluate (Add a b)     = (evaluate a)+(evaluate b)
evaluate (Multiply a b)= (evaluate a)*(evaluate b)

exampleExpression::Expression
exampleExpression = Add	
					  (Add
					     (Constant 20)
						 (Constant 17))
					  (Add
					     (Variable X)
						 (Multiply
						   (Add
						     (Constant 14)
							 (Constant 7))
						   (Constant 2)))

						
tryOptimize::Expression -> Expression
tryOptimize (Add(Constant a) (Constant b)) = Constant(a+b)
tryOptimize (Multiply(Constant a)(Constant b)) = Constant(a*b)
tryOptimize a = a

evaluatePartially::Expression->Expression
evaluatePartially (Add a b)      = tryOptimize(Add(evaluatePartially a)(evaluatePartially b))
evaluatePartially (Multiply a b) = tryOptimize(Multiply(evaluatePartially a)(evaluatePartially b))
evaluatePartially a = a