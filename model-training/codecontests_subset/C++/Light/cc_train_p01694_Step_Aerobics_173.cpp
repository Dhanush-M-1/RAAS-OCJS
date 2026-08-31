#include<iostream>
using namespace std;
int n;
int main()
{
	while(cin>>n,n)
	{
		string s;int flag=0,r=0,l=0,cnt=0;
		for(int i=0;i<n;i++)
		{
			cin>>s;
			if(s=="lu")
			{
				l=1;
				if(flag==0&&r==l)cnt++,flag=1;
			}
			else if(s=="ru")
			{
				r=1;
				if(flag==0&&r==l)cnt++,flag=1;
			}
			else if(s=="ld")
			{
				l=0;
				if(flag==1&&r==l)cnt++,flag=0;
			}
			else
			{
				r=0;
				if(flag==1&&r==l)cnt++,flag=0;
			}
		}
		cout<<cnt<<endl;
	}
}

