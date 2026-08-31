#include<bits/stdc++.h>
using namespace std;
int n;
long long D;
long long a[200005];
pair<long long,int> co1[200005],co2[200005];
struct Node{
	int v,u;
	long long cost;
	Node(int xv=0,int xu=0,long long xcost=0){
		v=xv;u=xu;cost=xcost;
	}
	bool operator <(const Node &a) const{
		return cost<a.cost;
	}
};
vector<Node> edge;
void solve(int l,int r){
	if(l>=r) return;
	int mid=l+r>>1;
//	cout<<l<<" "<<r<<endl;
	solve(l,mid);solve(mid+1,r);
	sort(co1+l,co1+mid+1);sort(co2+mid+1,co2+r+1);
	for(int i=l;i<=mid;i++){
		edge.push_back(Node(co1[i].second,co2[mid+1].second,co1[i].first+co2[mid+1].first));
	}
	for(int i=mid+1;i<=r;i++){
		edge.push_back(Node(co1[l].second,co2[i].second,co1[l].first+co2[i].first));
	}
}
int pa[200005];
int find(int x){
	return (pa[x]==x)?x:pa[x]=find(pa[x]);
}
void merge(int x,int y){
	x=find(x);y=find(y);
	pa[x]=y;
}
int main(){
	scanf("%d %lld",&n,&D);
	for(int i=0;i<n;i++){
		scanf("%lld",&a[i]);
		co1[i]=make_pair(a[i]-(i+1)*D,i);
		co2[i]=make_pair(a[i]+(i+1)*D,i);
	}
	solve(0,n-1);
	sort(edge.begin(),edge.end());
//	cout<<"lala"<<endl;
	for(int i=0;i<=n;i++) pa[i]=i;
	long long res=0;
	for(int i=0;i<edge.size();i++){
		int v=edge[i].v,u=edge[i].u;
		long long co=edge[i].cost;
//		cout<<u<<" "<<v<<" "<<co<<endl;
		if(find(v)!=find(u)){
			merge(v,u);
			res+=co;
		}
	}
	cout<<res;
}