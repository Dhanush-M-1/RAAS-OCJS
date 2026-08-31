#include "bits/stdc++.h"
using namespace std;
typedef long long int ll;
const ll N = (1e5);
#define mod 1000000007
#define mp make_pair
#define ip pair<ll,ll>
#define lcm(a,b) (a*b)/gcd(a,b);
#define all(x) x.begin(),x.end()
#define setbit(x) __builtin_popcount(x)
#define print(x) for(auto i:x)cout<<i<<" "
#define pb push_back
#define forn(i,a,b)for(int i=a;i<b;i++)
#define db1(x) cout<<#x<<"="<<x<<endl;
#define db2(x,y) cout<<#x<<"="<<x<<" "<<#y<<"="<<y<<endl;
#define db3(x,y,z) cout<<#x<<"="<<x<<" "<<#y<<"="<<y<<" "<<#z<<"="<<z<<endl;
#define fillit(x,val) fill(x.begin(),x.end(),val);
#define fast ios_base::sync_with_stdio(false); cin.tie(NULL)
#define len(s) s.length()

int main(int argc, char const *argv[])
{

fast;


int t;
cin>>t;

while(t-->0)
{
   int k,n,m;
   cin>>k>>n>>m;

   int a[n];
   int b[m];
   bool ans=true;

   for(int i=0;i<n;i++)cin>>a[i];
   for(int i=0;i<m;i++)cin>>b[i];
   vector<int>res(n+m);

   int i=0,j=0;int pt=0;
  
   while(i<n||j<m)
   { 
     bool done=false;
     
     if(i<n)
     { 
       if(a[i]==0){res[pt]=0;i++;k++;done=1;}
       else if(a[i]<=k){res[pt]=a[i];i++;done=1;}
     }

     if(j<m&&!done)
     {  
       if(b[j]==0){res[pt]=0;j++;k++;done=1;}
       else if(b[j]<=k){res[pt]=b[j];j++;done=1;}
     }
    
     if(!done){ans=false;break;}

     pt++;
   }

   if(ans){
   print(res);
   cout<<endl;
   }

   else cout<<"-1"<<endl;
   


}


}