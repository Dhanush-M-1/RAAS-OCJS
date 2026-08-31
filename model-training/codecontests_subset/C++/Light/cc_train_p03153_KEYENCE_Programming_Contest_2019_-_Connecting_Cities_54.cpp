#include<stdio.h>
#include<math.h>
#include<algorithm>
#include<queue>
#include<deque>
#include<stack>
#include<string>
#include<string.h>
#include<vector>
#include<set>
#include<map>
#include<bitset>
#include<stdlib.h>
#include<cassert>
#include<time.h>
#include<bitset>
using namespace std;
const long long mod=1000000007;
const long long inf=mod*mod;
const long long d2=(mod+1)/2;
const long double EPS=1e-9;
const long double PI=acos(-1.0);
int ABS(int a){return max(a,-a);}
long long ABS(long long a){return max(a,-a);}
long double ABS(long double a){return max(a,-a);}
int p[210000];
int UF[210000];
int FIND(int a){
	if(UF[a]<0)return a;
	return UF[a]=FIND(UF[a]);
}
void UNION(int a,int b){
	a=FIND(a);b=FIND(b);if(a==b)return;UF[a]+=UF[b];UF[b]=a;
}
pair<int,int> t[210000];
vector<pair<long long,pair<int,int> > >v;

pair<long long,int> segtree[2][524288];
pair<long long,int> query(int a,int b,int c,int d,int e,int f){
	if(d<a||b<c)return make_pair(inf,-1);
	if(c<=a&&b<=d)return segtree[f][e];
	return min(query(a,(a+b)/2,c,d,e*2,f),query((a+b)/2+1,b,c,d,e*2+1,f));
}
void update(int a,long long b,int c){
	int at=a;
	a+=262144;
	while(a){
		segtree[c][a]=min(segtree[c][a],make_pair(b,at));
		a/=2;
	}
}

int main(){
	int a,b;scanf("%d%d",&a,&b);
	for(int i=0;i<a;i++)scanf("%d",p+i);
	for(int i=0;i<a;i++){
		t[i]=make_pair(p[i],i);
	}
	for(int i=0;i<524288;i++)for(int j=0;j<2;j++)segtree[j][i]=make_pair(inf,-1);
	std::sort(t,t+a);

	for(int i=0;i<a;i++){
		int I=t[i].second;
		pair<long long,int> L=query(0,262143,0,I,1,1);
		pair<long long,int> R=query(0,262143,I,a-1,1,0);
		if(L.second!=-1){
			v.push_back(make_pair((long long)(I-L.second)*b+p[I]+p[L.second],make_pair(I,L.second)));
		}
		if(R.second!=-1){
			v.push_back(make_pair((long long)(R.second-I)*b+p[I]+p[R.second],make_pair(I,R.second)));
		}
		update(I,p[I]+(long long)b*I,0);
		update(I,p[I]+(long long)b*(a-I),1);
	}
	std::sort(v.begin(),v.end());
	long long ret=0;
	for(int i=0;i<a;i++)UF[i]=-1;
	for(int i=0;i<v.size();i++){
		if(FIND(v[i].second.first)!=FIND(v[i].second.second)){
			UNION(v[i].second.first,v[i].second.second);
			ret+=v[i].first;
		}
	}
	printf("%lld\n",ret);
}