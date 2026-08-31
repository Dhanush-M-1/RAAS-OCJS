#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll,ll> P;
#define fr(i,n) for(int i=0;i<n;i++)

ll par[200010],ranki[200010]; 

void init(int n){
  fr(i,n){
    par[i]=i;
    ranki[i]=0;
  }
}

int find(int x){
  if(par[x]==x) return x;
  else return par[x]=find(par[x]);
}
 
void unit(int x,int y){
  x=find(x);
  y=find(y);
  if(x==y) return;
  if(ranki[x]<ranki[y]) par[x]=y;
  else par[y]=x;
  if(ranki[x]==ranki[y]) ranki[x]++;
}
 
bool same(int x,int y){
  return find(x)==find(y);
}


struct road{
  ll dm,cd,ct;
  bool operator<(const road& right) const{
    return ct<right.ct;
  }
};
vector<road> roads;


int main(){
  ll n,d,a[200010],ans=0,cnt=0;
  cin>>n>>d;
  fr(i,n) cin>>a[i];
  priority_queue<P,vector<P>,greater<P>> q;
  fr(i,n){
    while(!q.empty()){
      ll j=q.top().second;
      if(a[j]>a[i]){
        q.pop();
        continue;
      }
      else{
        roads.push_back((road){i,j,a[i]+a[j]+d*(i-j)});
        break;
      }
    }
    q.push(make_pair(a[i]-d*i,i));
  }
  while(!q.empty()) q.pop();
  for(int i=n-1;i>=0;i--){
    while(!q.empty()){
      ll j=q.top().second;
      if(a[j]>a[i]){
        q.pop();
        continue;
      }
      else{
        roads.push_back((road){i,j,a[i]+a[j]+d*(j-i)});
        break;
      }
    }
    q.push(make_pair(a[i]+d*i,i));
  }
  init(n);
//  for(auto it=roads.begin();it!=roads.end();it++) cout<<(*it).dm<<" "<<(*it).cd<<" "<<(*it).ct<<endl;
  sort(roads.begin(),roads.end());
  for(auto it=roads.begin();cnt<n-1;it++){
    road r=*it;
    if(same(r.dm,r.cd)) continue;
    unit(r.dm,r.cd);
    ans+=r.ct;
    cnt++;
  }
  cout<<ans<<endl;
}