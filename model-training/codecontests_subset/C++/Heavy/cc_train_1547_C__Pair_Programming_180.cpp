#include <bits/stdc++.h>
using namespace std;

typedef long long int ll ;
#define f0(i,n)         for(i=0;i<n;i++)
#define f1(i,n)         for(i=1;i<n;i++)
#define fab(i,a,b)     for(i=a;i<=b;i++)
#define fabr(i,a,b)     for(i=b;i>=a;i--)
#define bs              binary_search 
#define memo(a,b)      memset(a,b,sizeof(a))
#define fstl(i,v)      for(auto i=v.begin();i!=v.end();i++) cout<<*i<<" "
#define lb              lower_bound 
#define ub              upper_bound
#define sps(x,y)        fixed<<setprecision(y)<<x
#define all(v)          v.begin(),v.end()
#define allr(x)         x.rbegin(),x.rend()
#define INF             1000000000000

void fast()
{
  ios_base::sync_with_stdio(0);
  cin.tie(0); cout.tie(0);

}

int main()
{
  
  fast(); 
  
  ll pr; 
  cin>>pr; 
  while(pr--)
  {
   ll k,n,m,i,j,c=0,f=0; 
   cin>>k>>n>>m; 
   ll a[n],b[m]; 
   f0(i,n)
   {
     cin>>a[i];
   }
   f0(i,m)
   {
     cin>>b[i];
   }
   vector<ll> ans;
   deque<ll> a1,b1; 
   f0(i,n)
   {
     a1.push_back(a[i]);
   }
   f0(i,m)
   {
     b1.push_back(b[i]);
   }
  
   while(!(a1.empty())&&!(b1.empty()))
   {
     if(a1.front()==0)
     {
       while(a1.front()==0&&!(a1.empty()))
       {
         ans.push_back(a1.front());
         a1.pop_front();
       }
     }
     if(b1.front()==0)
     {
       while(b1.front()==0&&!(b1.empty()))
       {
         ans.push_back(b1.front());
         b1.pop_front();
       }
     }
   /*  if(!(b1.empty()))
     {
      ans.push_back(b1.front());
     b1.pop_front();
     }
    if(!(a1.empty()))
    {
   
     ans.push_back(a1.front());
     a1.pop_front();
    }*/
     if(!(a1.empty())&&!(b1.empty()))
     {
     
     if(a1.front()>b1.front())
     {
     ans.push_back(b1.front());
     b1.pop_front();
     }
     else
     {
       ans.push_back(a1.front());
       a1.pop_front();
     }
    }
  /*  while(!(b1.empty()))
    {
     ans.push_back(b1.front());
     b1.pop_front();
    }
    while(!(a1.empty()))
    {
   
     ans.push_back(a1.front());
     a1.pop_front();
    }*/  
  }
  while(!(b1.empty()))
    {
     ans.push_back(b1.front());
     b1.pop_front();
    }
    while(!(a1.empty()))
    {
   
     ans.push_back(a1.front());
     a1.pop_front();
    }
  // fstl(pp,ans);
   for(i=0;i<n+m;i++)
   {
    if(ans[i]==0) 
    {
      c++;
    }
    else
    {
      if(ans[i]>c+k)
      {
        f=1; 
        break;
      }
    }
   }
   if(f==1)
   {
     cout<<-1<<endl;
   }
   else
   {
     fstl(pp,ans); 
     cout<<endl;
   }
  } 
  return 0;
 }