#include<bits/stdc++.h>
using namespace std;
int x, k, q, t, a, low, up, jilei, kongsanjiao, now, ans, r[100007];
bool flag=0;
int cal(int tt, int lower = 0, int upper = x) {
    if (tt < lower) return lower;
    if (tt > upper) return upper;
    return tt;
}
int main()
{
    scanf("%d%d",&x,&k);
    for (int i = 1; i <= k; i++) scanf("%d",&r[i]);
        scanf("%d",&q);
    now = 1;
    low = x;
    up = 0;
    while (q--)
    {
        scanf("%d%d",&t,&a);
        while (t >= r[now] && now <= k)
        {
            kongsanjiao = (flag ? 1 : -1) * (r[now] - r[now - 1]);
            jilei += kongsanjiao;
            up = cal(kongsanjiao + up);
            low = cal(kongsanjiao + low);
            flag = !flag;
            now++;
        }
        ans = cal((flag ? 1 : -1) * (t - r[now - 1]) + cal(a + jilei, up, low));
        printf("%d\n",ans);
    }
    return 0;
}


