#include<bits/stdc++.h>

using namespace std;

#define fastio            ios_base::sync_with_stdio(false); cin.tie(NULL);
#define ifs               freopen("aa.in","r",stdin);
#define ofs               freopen("aa.out","w",stdout);
#define iof               ifs ofs
#define ll                long long
#define ld                long double
#define da(x,i)           cout << #x << "[" << i << "]=" << x[i] << "\n";
#define da2(x,i,y,j)      cout << #x << "[" << i << "]=" << x[i] << " ! " << #y << "[" << j << "]=" << y[j] << "\n";
#define d2a(x,i,j)        cout << #x << "[" << i << "][" << j << "]=" << x[i][j] << "\n";
#define db(x)             cout << #x << "=" << (x) << "\n";
#define db2(x,y)          cout << #x << "=" << (x) << " ! " << #y << "=" << (y) << "\n";
#define db3(x,y,z)        cout << #x << "=" << (x) << " ! " << #y << "=" << (y) << " ! " << #z << "=" << (z) << "\n";
#define db4(w,x,y,z)      cout << #w << "=" << (w) << " ! " << #x << "=" << (x) << " ! " << #y << "=" << (y) << " ! " << #z << "=" << (z) << "\n";
#define inf               LLONG_MAX
#define fr                first
#define sc                second
#define all(a)            a.begin(),a.end()


const ll N=2e5+70, M=1e9+7;
ll f[N];
ll tt,i,n,m,d,A;
string s;

int main()
{
   fastio
   for(i=0; i<10; i++)
      f[i]=1;
   for(i=10; i<N; i++)
      f[i]=(f[i-10]+f[i-9])%M;
   cin>>tt;
   while(tt--){
      cin>>n>>m;
      for(i=n,A=0; i; i/=10){
         d=i%10; d+=m;
         A=(A+f[d]+M)%M;
      }
      cout<< A <<"\n";
   }
}














































