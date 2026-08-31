#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int X,K;
vector<pair<int,int> >A;
int main()
{
	cin>>X>>K;
	for(int i=0;i<K;i++)
	{
		int r;cin>>r;A.push_back(make_pair(r,-1));
	}
	int Q;cin>>Q;
	for(int i=0;i<Q;i++)
	{
		int t,a;cin>>t>>a;
		A.push_back(make_pair(t,a));
	}
	sort(A.begin(),A.end());
	int pre=0,d=1;
	int L=0,LA=0;
	int R=X,RA=X;
	for(pair<int,int>p:A)
	{
		if(p.second<0)
		{
			int t=p.first-pre;
			pre=p.first;
			if(d>0)
			{
				LA-=t;
				RA-=t;
				if(RA<0)
				{
					LA=RA=L=R=0;
				}
				else if(LA<0)
				{
					L+=-LA;
					LA=0;
					if(R<L)L=R;
				}
			}
			else
			{
				RA+=t;
				LA+=t;
				if(LA>X)
				{
					LA=RA=L=R=X;
				}
				else if(RA>X)
				{
					R-=RA-X;
					RA=X;
					if(R<L)R=L;
				}
			}
			d*=-1;
			//cout<<"L : "<<L<<", LA : "<<LA<<endl;
			//cout<<"R : "<<R<<", RA : "<<RA<<endl<<endl;
		}
		else
		{
			int a=p.second;
			if(a<L)a=LA;
			else if(a>R)a=RA;
			else
			{
				a=LA+a-L;
			}
			int t=p.first-pre;
			cout<<(d>0?max(0,a-t):min(a+t,X))<<endl;
		}
	}
}
