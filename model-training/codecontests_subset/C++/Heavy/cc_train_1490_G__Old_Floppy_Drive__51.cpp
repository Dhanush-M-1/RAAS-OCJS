#include <bits/stdc++.h>
using namespace std;

int main()
{
  int tc;cin>>tc;
  while(tc--)
  {
    int n,m;cin>>n>>m;
    vector<int> v(n);
    for(int i=0;i<n;i++)cin>>v[i];


    vector<long long> ps={v[0]}, ix={0};
    long long sp=v[0];
    for(int i=1;i<n;i++)
    {
      sp+=v[i];
      if(sp>=ps.back()){ps.push_back(sp);ix.push_back(i);}
    }

    for(int i=0;i<m;i++)
    {
      int x;cin>>x;
      if(ps.back()<x && sp<=0){cout<<"-1 ";continue;}

      long long ts = 0LL;

      if(ps.back()<x)ts=(x-ps.back()+sp-1)/sp;

      int pos = ix[lower_bound(ps.begin(),ps.end(), x-(sp*1LL*ts))-ps.begin()];
      cout<<pos+(ts*(n))<<" ";
    }
    cout<<endl;

  }
}
