/*

please pass my code

use a kruskal's idea
every edge should be between adjacent connected components
(no idea why this is the case, it just seems to work)

*/

#include <stdio.h>
#include <set>
#include <utility>

long long minn(long long a,long long b){return a<=b?a:b;}

int n;
long long d;
int a[200005];

// segment is [i,ptr2[i])
int ptr1[200005];
int ptr2[200005];
long long c1[200005];
long long c2[200005];

std::set<std::pair<int,int>> kruskal;
bool done[200005];
long long ans=0;

int main()
{
    #ifdef NOT_DMOJ
    freopen("data.txt","r",stdin);
    #endif // NOT_DMOJ
    scanf("%d%lld",&n,&d);
    for (int i=1; i<=n; i++) {
        scanf("%d",a+i);
        ptr1[i]=i-1;
        ptr2[i]=i+1;
        c1[i]=c2[i]=a[i];
    }
    for (int i=2; i<=n; i++) {
        //kruskal.insert({c2[i-1]+c1[i],i});
        kruskal.insert({c2[i-1],i});
        kruskal.insert({c1[i],i});
    }
    done[1]=1;
    done[n+1]=1;
    while (!kruskal.empty()) {
        // pop lowest edge from set
        int i2=kruskal.begin()->second;
        kruskal.erase(kruskal.begin());
        if (done[i2]) continue;
        done[i2]=1;
        int i3=ptr2[i2];
        int i1=ptr1[i2];
        int i0=ptr1[i1];
        ans+=c2[i1]+d+c1[i2];
        //printf("%d ans+=%d\n",i2,c2[i1]+d+c1[i2]);
        // ptr stuff
        ptr2[i0]=i1;
        ptr2[i1]=i3;
        ptr1[i3]=i1;
        ptr1[i1]=i0;
        // merge i1 with i2
        if (c1[i1]>c1[i2]+(i2-i1)*d) {
            c1[i1]=c1[i2]+(i2-i1)*d;
            kruskal.insert({c2[i0],i1});
            kruskal.insert({c1[i1],i1});
        }
        c2[i1]=minn(c2[i2],c2[i1]+(i3-i2)*d);
        kruskal.insert({c2[i1],i3});
        kruskal.insert({c1[i3],i3});
        //printf("new ends %lld %lld\n",c1[i1],c2[i1]);
    }
    printf("%lld\n",ans);
}
