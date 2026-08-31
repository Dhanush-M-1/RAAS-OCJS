#include<bits/stdc++.h>
using namespace std;
long long t,a,b,c,d;
long long gcd(long long x,long long y){return !y?x:gcd(y,x%y);}
int main()
{
	cin>>t;
	while(t--)
	{
		cin>>a>>b>>c>>d;
		if(a<b||d<b){puts("No");continue;}
		if(c>=b-1){puts("Yes");continue;}
		long long g=gcd(d,b);
		if(b-c-1>=g){puts("No");continue;}
		puts(((c-a+1)%g+g)%g>((b-a-1)%g+g)%g||(c-a+1)%g==0?"No":"Yes");
	}
	return 0;
}
