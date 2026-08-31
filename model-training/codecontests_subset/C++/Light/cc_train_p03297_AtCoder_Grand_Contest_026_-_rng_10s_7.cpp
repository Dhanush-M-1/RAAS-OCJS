#include<iostream>
#include<algorithm>
using namespace std;

template<typename T>
T gcd(T a,T b)
{
	if(a<b) swap(a,b);
	T r = a % b;
	while(r!=0)
	{
		a = b;
		b = r;
		r = a % b;
	}
	return b;
}
int main()
{
	int T;
	cin >> T;
	unsigned long int A,B,C,D;
	for(int i=0;i<T;i++)
	{
		scanf("%ld%ld%ld%ld",&A,&B,&C,&D);
		if(A<B || D<B || C<A%B || C<B-gcd(B,D))	puts("No");
		else		puts("Yes");
	}
	return 0;
}