#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<iomanip>
#include<set>

using namespace std;

int keta(long long n)
{
	int cnt=0;
	while(true)
	{
		cnt++;
		n/=10;
		if(n<=0)break;
	}
	return cnt;
}

int main()
{
	int q;
	cin >> q;
	for(int i=0;i<q;i++)
	{
		long long n;
		cin >> n;
		long long cnt=0;
		while(true)
		{
			int ke=keta(n);
			if(ke<=1)
				break;
			cnt++;
			long long tmp=0;
			for(int j=0;j<ke;j++)
			{
				long long tmptmp;
				long long un,up;
				long long aa=1;
				for(int k=0;k<j;k++)
				{
					aa*=10;
				}
				un=n%aa;
				up=n/aa;
				tmptmp=un*up;
					
				if(tmp<tmptmp)tmp=tmptmp;

			}
			n=tmp;
		}

		cout << cnt << endl;


	}
}
