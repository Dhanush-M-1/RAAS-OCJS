#include <bits/stdc++.h>
#define int long long
#define INF 1000000000000000007
using namespace std;

int n,d,p[200010],a[200010];
vector<pair<int,pair<int,int> > > edges;

int find_set(int x)
{
	if(p[x]==x) return x;
	else return p[x]=find_set(p[x]);
}

bool unite(int x,int y)
{
	int rootx=find_set(x),rooty=find_set(y);
	if(rootx==rooty) return false;
	else{
		p[rooty]=rootx;
		return true;
	}
}

void solve(int l,int r)
{
	if(l>=r) return;
	int m=(l+r)/2;
	
	int minv1=INF,pos1=-1;
	for(int i=l;i<=m;i++){
		int val=a[i]-d*i;
		if(val<minv1){
			minv1=val;
			pos1=i;
		}
	}
	
	int minv2=INF,pos2=-1;
	for(int i=m+1;i<=r;i++){
		int val=a[i]+d*i;
		if(val<minv2){
			minv2=val;
			pos2=i;
		}
	}
	
	for(int i=l;i<=m;i++){
		edges.push_back(make_pair(minv2+a[i]-d*i,make_pair(i,pos2)));
	}
	for(int i=m+1;i<=r;i++){
		edges.push_back(make_pair(minv1+a[i]+d*i,make_pair(pos1,i)));
	}
	solve(l,m);
	solve(m+1,r);
}

signed main()
{
	ios::sync_with_stdio(false);
	cin>>n>>d;
	for(int i=1;i<=n;i++){
		cin>>a[i];
		p[i]=i;
	}
	solve(1,n);
	int cnt=0,ans=0;
	sort(edges.begin(),edges.end());
	for(int i=0;i<edges.size()&&cnt<n-1;i++){
		if(unite(edges[i].second.first,edges[i].second.second)){
			ans+=edges[i].first;
			cnt++;
		}
	}
	cout<<ans<<endl;
	return 0;
}