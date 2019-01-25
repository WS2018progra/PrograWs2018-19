
% @autor Maximilian/Mika



% a)

isList(nil).

isList(cons(_,X)) :- 
  isList(X).

% b) 

toPrologList(nil, []).
toPrologList(cons(X,XS),[Y|YS]):- X is Y, toPrologList(XS,YS).

% c)

flatten([[X|S]|T], Y) :- flatten([X|[S|T]], Y).
flatten([[]|S], Y) :- flatten(S, Y).
flatten([X|S], [X|T]) :- \+(X = []), \+(X = [_|_]), flatten(S, T).
flatten([], []).
  
% d)

appendElement(X, Y, Z):- 
  append(X, [Y], Z).
  
% e)

reverseList([X|Xs], R) :-
  reverse(Xs,T),
  append(T, [X], R).