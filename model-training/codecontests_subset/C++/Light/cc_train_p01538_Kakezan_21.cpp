#include<iostream>
#include<algorithm>
#include<vector>
#include<map>
#include<set>
using namespace std;
int n;
int main()
{
	cin>>n;
	for(;n--;)
	{
		int a;cin>>a;
		int cnt=0;
		while(a>=10)
		{
			int nexta=0;
			for(int i=10;i<=a;i*=10)
			{
				int now=a%i*(a/i);
				nexta=max(nexta,now);
			}
			a=nexta;
			cnt++;
		}
		cout<<cnt<<endl;
	}
}
