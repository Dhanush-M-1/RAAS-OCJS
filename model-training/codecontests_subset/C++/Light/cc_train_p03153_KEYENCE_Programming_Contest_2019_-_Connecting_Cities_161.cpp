#define DEB
#include<bits/stdc++.h>
#define REP(i,m) for(int i=0;i<(m);++i)
#define REPN(i,m,in) for(int i=(in);i<(m);++i)
#define ALL(t) (t).begin(),(t).end()
#define CLR(a) memset((a),0,sizeof(a))
#define pb push_back
#define mp make_pair
#define fr first
#define sc second

using namespace std;


#ifdef DEB
#define dump(x)  cerr << #x << " = " << (x) << endl
#define prl cerr<<"called:"<< __LINE__<<endl
#define dumpR(x) cerr<<"\x1b[31m"<<#x<<" = " <<(x)<<"\x1b[39m"<<endl
#define dumpY(x) cerr<<"\x1b[33m"<<#x<<" = " <<(x)<<"\x1b[39m"<<endl
#define dumpG(x) cerr<<"\x1b[32m"<<#x<<" = " <<(x)<<"\x1b[39m"<<endl
template<class T> void debug(T a,T b){ for(;a!=b;++a) cerr<<*a<<' ';cerr<<endl;}
#else
#define dump(x) ;
#define dumpR(x) ;
#define dumpY(x) ;
#define dumpG(x) ;
#define prl ;
template<class T> void debug(T a,T b){ ;}
#endif

template<class T> void chmin(T& a,const T& b) { if(a>b) a=b; }
template<class T> void chmax(T& a,const T& b) { if(a<b) a=b; }

typedef long long int lint;
typedef pair<int,int> pi;

namespace std{
  template<class S,class T>
  ostream &operator <<(ostream& out,const pair<S,T>& a){
    out<<'('<<a.fr<<','<<a.sc<<')';
    return out;
  }
}

const lint INF=1e18;
int n;
lint D;
lint ar[200005];
lint br[200005],cr[200005];
bool mark1[200005],mark2[200005];

bool done[200005];
lint pfxbr[200005],sfxcr[200005];
int main(){
  cin>>n>>D;
  REP(i,n){
    cin>>ar[i];
    br[i]=ar[i]-i*D;
    cr[i]=ar[i]+i*D;
  }

  pfxbr[0]=INF;
  REP(i,n){
    if(br[i]<pfxbr[i]){
      mark1[i]=1;
      pfxbr[i+1]=br[i];
    }else{
      pfxbr[i+1]=pfxbr[i];
    }
  }

  sfxcr[n]=INF;
  for(int i=n-1;i>=0;--i){
    if(cr[i]<sfxcr[i+1]){
      mark2[i]=1;
      sfxcr[i]=cr[i];
    }else{
      sfxcr[i]=sfxcr[i+1];
    }
  }
  int prev=-1;
  lint res=0;
  REP(i,n){
    if(mark1[i] && mark2[i]){
      if(~prev){
        res+=D*(i-prev)+ar[i]+ar[prev];
      }
      prev=i;
    }else{
      lint tmp1=pfxbr[i]+ar[i]+i*D;
      lint tmp2=sfxcr[i]+ar[i]-i*D;
      res+=min(tmp1,tmp2);
    }
  }
  cout<<res<<endl;
  return 0;
}



