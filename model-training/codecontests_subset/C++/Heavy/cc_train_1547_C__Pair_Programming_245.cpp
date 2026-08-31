#include <bits/stdc++.h>
using namespace std;
#define rapido ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define Ff(i,j,n)  for (i = j ; i < n; i++)
#define Fb(i,j,n)  for (i = n-1 ; i >= j; i--)
#define ll long long
#define pb push_back
#define infi 1000006
#define ve vector<int>
#define m1(v) *max_element(v.begin(),v.end())
#define m2(v) *min_element(v.begin(),v.end())
#define sv(v) sort(v.begin(),v.end())
#define sa(a,n) sort(a,a+n)
#define svd(v) sort(v.begin(),v.end(), greater<ll>())
#define sad(a,n) sort(a,a+n,greater<ll>())
#define MOD 1000000007
#define lb lower_bound
#define ub upper_bound
#define ff first
#define ss second
#define all(v) (v).begin(),(v).end()
typedef vector<long long> vll;
typedef pair<long long, long long> pll;
typedef vector<int> vi;
typedef vector<bool> vb;
typedef vector<vll> vvll;
typedef vector<vi> vvi;
typedef vector<pll> vpll;

int main()
{
  rapido
  ll i,j,k,tt,n,m,x,y;
  #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
  #endif
    cin>>tt;
    while(tt--)
    {
      int k,n,m;
      cin>>k>>n>>m;
      vi v(n);
      vi a(m);
      
      Ff(i,0,n)
      cin>>v[i];
      Ff(i,0,m)
      cin>>a[i];
      int i=0;j=0;
      int c=k;
      vi b;
      while(i<v.size()&&j<a.size())
      {
        if(v[i]==0)
          {b.pb(v[i]);c++;i++;continue;}
        else if(v[i]!=0&&c>=v[i])
        {
          {b.pb(v[i]);i++;continue;}
        }
        else if(v[i]!=0&&c<v[i]&&a[j]==0)
          {b.pb(a[j]);c++;j++;continue;}
        else if(v[i]!=0&&c<v[i]&&a[j]!=0&&c>=a[j])
          {b.pb(a[j]);j++;continue;}
        else if(v[i]!=0&&c<v[i]&&a[j]!=0&&c<a[j])
          {b.pb(-1);break;}
      }
      if(b[b.size()-1]==-1)
        {cout<<-1<<endl;continue;}
      while(i<v.size())
      {
        if(v[i]==0)
          {b.pb(v[i]);c++;i++;continue;}
        else if(v[i]!=0&&c>=v[i])
        {
          {b.pb(v[i]);i++;continue;}
        }
        else if(v[i]!=0&&c<v[i])
          {b.pb(-1);break;}
      }
      if(b[b.size()-1]==-1)
        {cout<<-1<<endl;continue;}
      while(j<a.size())
      {
        if(a[j]==0)
          {b.pb(a[j]);c++;j++;continue;}
        else if(a[j]!=0&&c>=a[j])
        {
          {b.pb(a[j]);j++;continue;}
        }
        else if(a[j]!=0&&c<a[j])
          {b.pb(-1);break;}
      }
      if(b[b.size()-1]==-1)
        {cout<<-1<<endl;continue;}
      Ff(i,0,b.size())
      cout<<b[i]<<" ";
      cout<<endl;
    }
  return 0;
}
