#include<iostream>
#include<algorithm>
using namespace std;

template<typename T>
T gcd(T a,T b)
{
  return b==0?a:gcd(b,a%b);
}
int main()
{
	int T; scanf("%d",&T);
	unsigned long int A,B,C,D;
	for(int i=0;i<T;i++)
	{
		scanf("%ld%ld%ld%ld",&A,&B,&C,&D);
		if(A<B || D<B || C<A%B || C<B-gcd(B,D))	puts("No");
		else		puts("Yes");
	}
	return 0;
}