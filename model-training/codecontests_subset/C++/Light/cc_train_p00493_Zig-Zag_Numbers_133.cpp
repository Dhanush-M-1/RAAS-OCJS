#include<bits/stdc++.h>
using namespace std;
using Int = long long;

template<typename T,T MOD = 1000000007>
struct Mint{
  T v;
  Mint():v(0){}
  Mint(signed v):v(v){}
  Mint(long long t){v=t%MOD;if(v<0) v+=MOD;}
  
  Mint& operator+=(Mint a){v+=a.v;if(v>=MOD)v-=MOD;return *this;}
  Mint& operator-=(Mint a){v+=MOD-a.v;if(v>=MOD)v-=MOD;return *this;}
  Mint& operator*=(Mint a){v=1LL*v*a.v%MOD;return *this;}
  
  Mint operator+(Mint a){return Mint(v)+=a;};
  Mint operator-(Mint a){return Mint(v)-=a;};
  Mint operator*(Mint a){return Mint(v)*=a;};

  Mint operator-(){return v?MOD-v:v;}

  bool operator==(const Mint a)const{return v==a.v;}
  bool operator!=(const Mint a)const{return v!=a.v;}

};

//INSERT ABOVE HERE
using M = Mint<int, 10000>;
M dp[505][505][2][2][3][10];
bool used[505][505][2][2][3][10];
int m;
M dfs(string &a,int pos,int v,int tight,int lz,int inc,int curr){
  M &res=dp[pos][v][tight][lz][inc][curr];
  if(used[pos][v][tight][lz][inc][curr]) return res;
  used[pos][v][tight][lz][inc][curr]=1;
  int n=a.size();
  if(pos==n) return res=M(v==0);
  
  res=M(0);
  for(int k=0;k<10;k++){
    if(tight&&a[pos]-'0'<k) continue;
    int npos=pos+1;
    int nv=(v*10+k)%m;
    int ntight=tight&&(a[pos]-'0'==k);
    int nlz=lz&&(k==0);
    int ninc=0;
    int ncurr=k;
    
    if(!lz) ninc=curr<k?1:2;
    if(!lz&&(curr==k||inc==ninc)) continue;
    res+=dfs(a,npos,nv,ntight,nlz,ninc,ncurr);
  }
  return res;
}

int zigzag(string s){
  int n=s.size();
  for(int i=1;i<n;i++) if(s[i-1]==s[i]) return 0;
  for(int i=1;i+1<n;i++) if(s[i-1]<s[i]&&s[i]<s[i+1]) return 0;
  return 1;
}

signed main(){
  string a,b;
  cin>>a>>b>>m;  
  M ans;

  memset(used,0,sizeof(used));
  ans+=dfs(b,0,0,1,1,0,0);
  memset(used,0,sizeof(used));
  ans-=dfs(a,0,0,1,1,0,0);
  
  if(zigzag(a)) ans+=M(1);
  cout<<ans.v<<endl;
  return 0;
}

