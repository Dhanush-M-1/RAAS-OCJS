#include <bits/stdc++.h>

using namespace std;

//int dirs[4][2]={{-1,0},{1,0},{0,-1},{0,1}};
//int dirs[8][2]={{-1,0},{0,-1},{0,1},{1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

long long modd=1e9+7;

vector<int> dsu;
vector<int> height;
vector<bool> has_loop;

int find_leader(int u)
{
    if(dsu[u]==u) return u;
    return dsu[u]=find_leader(dsu[u]);
}

void voeg_samen(int u, int v)
{
    u=find_leader(u);
    v=find_leader(v);
    if(u==v) return;
    if(height[u]>height[v])
    {
        dsu[v]=u;
        if(has_loop[v]) has_loop[u]=true;
    }
    else if(height[u]<height[v])
    {
        dsu[u]=v;
        if(has_loop[u]) has_loop[v]=true;
    }
    else
    {
        dsu[u]=v;
        height[v]++;
        if(has_loop[u]) has_loop[v]=true;
    }
}

int main()
{
    //ios::sync_with_stdio(false);
    //freopen("inp.in","r",stdin);
    //freopen("outp.out","w",stdout);
    int n, m;
    scanf("%d %d", &n, &m);
    dsu.assign(m,-1);
    has_loop.assign(m,false);
    height.assign(m,0);
    for(int i=0; i<m; i++)
    {
        dsu[i]=i;
    }
    vector<int> ans_indices;
    for(int i=0; i<n; i++)
    {
        int k;
        scanf("%d", &k);
        if(k==1)
        {
            int u;
            scanf("%d", &u);
            u--;
            int leader=find_leader(u);
            if(has_loop[leader])
            {
                continue;
            }
            else
            {
                has_loop[leader]=true;
                ans_indices.push_back(i);
            }
        }
        else
        {
            int u, v;
            scanf("%d %d", &u, &v);
            u--;
            v--;
            int ld1=find_leader(u);
            int ld2=find_leader(v);
            //cerr << u << " " << v << endl;
            //cerr << ld1 << " " << ld2 << " " << has_loop[ld1] << " " << has_loop[ld2] << endl;
            if((has_loop[ld1]&&has_loop[ld2])||ld1==ld2)
            {
                continue;
            }
            else
            {
                voeg_samen(ld1,ld2);
                ans_indices.push_back(i);
            }
        }
        /*for(int j=0; j<m; j++)
        {
            int ld=find_leader(j);
            cerr << j << " has loop: " << has_loop[ld] << endl;
        }
        cerr << endl;*/
    }
    long long pow_two=1;
    for(int i=0; i<ans_indices.size(); i++)
    {
        pow_two=(pow_two*2)%modd;
    }
    int a2=ans_indices.size();
    printf("%I64d %d\n",pow_two,a2);
    for(int i=0; i<ans_indices.size(); i++)
    {
        if(i != 0) printf(" ");
        printf("%d",ans_indices[i]+1);
    }
    printf("\n");
    return 0;
}
