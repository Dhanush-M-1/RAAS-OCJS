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
	int L=0,R=X,AA=0;
	for(pair<int,int>p:A)
	{
		if(p.second<0)
		{
			int t=p.first-pre;
			pre=p.first;
			if(d>0)
			{
				AA-=t;
				if(L+AA<0)
				{
					L=-AA;
				}
				if(L>R)R=L;
			}
			else
			{
				AA+=t;
				if(R+AA>X)
				{
					R=X-AA;
				}
				if(L>R)L=R;
			}
			d*=-1;
		}
		else
		{
			int a=p.second;
			if(a<L)a=L;
			else if(a>R)a=R;
			a+=AA;
			int t=p.first-pre;
			cout<<(d>0?max(0,a-t):min(a+t,X))<<endl;
		}
	}
}
