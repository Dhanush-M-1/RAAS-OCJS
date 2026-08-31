#include<iostream>
using namespace std;
long gcd(long a,long b){return b?gcd(b,a%b):a;}
int t;
long A,B,C,D;
int main()
{
	cin>>t;
	for(;t--;)
	{
		cin>>A>>B>>C>>D;
		if(A<B)cout<<"No"<<endl;
		else
		{
			if(B>D)cout<<"No"<<endl;
			else
			{
				if(B-1<=C)cout<<"Yes"<<endl;
				else
				{
					long b=B-A%B,c=C-A%B;
					long dis=gcd(B,D);
					if(b>(c+dis)/dis*dis)cout<<"No"<<endl;
					else cout<<"Yes"<<endl;
				}
			}
		}
	}
}
