#include<stdio.h>
 
template<typename T>
T gcd(T x,T y){return y?gcd(y,x%y):x;}
 
int main()
{
	int T; scanf("%d",&T);
	unsigned long int A,B,C,D;
	for(;0<T;T--)
	{
		scanf("%ld%ld%ld%ld",&A,&B,&C,&D);
		if(A<B||D<B||C<A%B||C<B-gcd(B,D)) puts("No");
		else puts("Yes");
	}
}