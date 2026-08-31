#include<iostream>
#include<set>
#include<cstdlib>
#include<vector>
#include<algorithm>

using namespace std;

long long n,m,a,b,p,q;

long long mul(long long a,long long b){
  __int128 r=a;
  r*=b;
  if(r>1e18)throw 0;
  return r;
}

int main(){
  cin>>n>>m>>a>>b>>p>>q;
  if(a==1&&b==1){
    long long c=m/(p+q);
    cout<<min(m-min(n,c)*(p+q),llabs(min(n,c+1)*(p+q)-m))<<endl;
  }else{
    long long t[55]={};
    t[0]=p+q;
    long long ak=1,bk=1;
    try{
      for(int i=1;i<min(n,42ll);i++){
	ak=mul(ak,a);
	bk=mul(bk,b);
	t[i]=mul(p,ak)+mul(q,bk);
      }
    }catch(...){
    }
    vector<long long> s(1<<21);
    for(int i=0;i<1<<21;i++){
      long long c=0;
      for(int j=0;j<21;j++){
	c+=(i>>j&1)*t[j+21];
      }
      s[i]=c;
    }
    sort(begin(s),end(s));
    s.erase(unique(begin(s),end(s)),end(s));
    long long ans=1e18;
    for(int i=0;i<1<<21;i++){
      long long c=0;
      for(int j=0;j<21;j++){
	c+=(i>>j&1)*t[j];
      }
      auto it=lower_bound(begin(s),end(s),m-c);
      if(it!=s.end()){
	ans=min(ans,llabs(m-*it-c));
      }
      if(it!=s.begin()){
	it--;
	ans=min(ans,llabs(m-*it-c));
      }
    }
    cout<<ans<<endl;
  }
}