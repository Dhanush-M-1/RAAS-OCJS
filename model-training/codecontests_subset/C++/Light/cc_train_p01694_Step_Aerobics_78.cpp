#include<iostream>
using namespace std;
int N;
int main()
{
	while(cin>>N,N)
	{
		int pre=0,ans=0;
		int x=0,y=0;
		for(int i=0;i<N;i++)
		{
			string s;cin>>s;
			if(s=="lu")
			{
				x=1;
			}
			else if(s=="ru")
			{
				y=1;
			}
			else if(s=="ld")
			{
				x=0;
			}
			else
			{
				y=0;
			}
			if(x==1&&y==1)
			{
				if(pre==0)ans++;
				pre=1;
			}
			else if(x==0&&y==0)
			{
				if(pre==1)ans++;
				pre=0;
			}
		}
		cout<<ans<<endl;
	}
}

