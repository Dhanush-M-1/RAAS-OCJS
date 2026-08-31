#include<bits/stdc++.h>
using namespace std;
#define IOS ios::sync_with_stdio(false)
#define maxn 5005

int a[maxn],b[maxn];
int main()
{
    IOS;

    int t;
    cin>>t;
    while(t--)
    {
        int k,n,m;
        cin>>k>>n>>m;

        for(int i=1; i<=n; i++)
            cin>>a[i];
        for(int i=1; i<=m; i++)
            cin>>b[i];

        vector<int>V;
        int pos1=1,pos2=1;
        while(pos1<=n||pos2<=m)
        {
            if(pos1<=n && pos2<=m)
            {
                if(a[pos1]==0)
                {
                    V.push_back(0);
                    pos1++;
                }
                else if(b[pos2]==0)
                {
                    V.push_back(0);
                    pos2++;
                }
                else if(a[pos1]<b[pos2])
                {
                    V.push_back(a[pos1]);
                    pos1++;
                }
                else
                {
                    V.push_back(b[pos2]);
                    pos2++;
                }
            }
            else if(pos1<=n && pos2>m)
            {
                V.push_back(a[pos1]);
                pos1++;
            }
            else
            {
                V.push_back(b[pos2]);
                pos2++;
            }
        }

        bool flag=true;
        for(int i=0; i<V.size(); i++)
        {
            if(V[i]==0)
                k++;
            else
            {
                if(V[i]>k)
                {
                    flag=false;
                    break;
                }
            }
        }
        if(flag)
        {
            for(int i=0;i<V.size();i++)
                cout<<V[i]<<" ";
        }
        else
            cout<<-1;
        cout<<"\n";
    }
    return 0;
}
