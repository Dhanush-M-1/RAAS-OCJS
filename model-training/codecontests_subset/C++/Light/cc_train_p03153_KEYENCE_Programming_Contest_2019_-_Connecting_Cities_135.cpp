#include <cstdio>
#include <unordered_map>
#include <algorithm>
#include <map>
#include <vector>
using namespace std;
const int N = 2e5 + 10;
int A[N];
int n, d;
long long ans;
int fa[N];
struct node
{
    int x, y;
    long long v;
    node(int X = 0, int Y = 0, long long V = 0)
    {
        x = X;
        y = Y;
        v = V;
    }
};
vector<node>edge;
bool operator<(const node &a, const node &b)
{
    return a.v < b.v;
}
long long G(int x)
{
    return A[x] + (long long)x * d;
}
long long F(int x)
{
    return A[x] - (long long)x * d;
}
void work(int l, int r)
{
    if (l == r)
    {
        return;
    }
    if (l + 1 == r)
    {
        edge.push_back(node(l, r, F(l) + G(r)));
        return;
    }
    int F_min = l, G_min = r;
    int mid = (l + r) / 2;
    for (int i = l ; i<= mid ; i ++)
        if (F(F_min) > F(i))
            F_min = i;
    for (int i = mid + 1 ; i<= r ; i ++)
        if (G(G_min) > G(i))
            G_min = i;
    for (int i = l ; i <= mid; i ++)
        edge.push_back(node(i, G_min, F(i) + G(G_min)));
    for (int i = mid + 1 ; i <= r; i ++)
        edge.push_back(node(F_min, i, F(F_min) + G(i)));
    work(l, mid);
    work(mid + 1, r);
}
int getfa(int x)
{
    return x == fa[x] ? x : fa[x] = getfa(fa[x]);
}
int main()
{
    scanf("%d %d", &n, &d);
    for (int i =  1; i <= n ; i ++)
        scanf("%d", &A[i]), fa[i] = i;
    work(1, n);
    sort(edge.begin(), edge.end());
    for (auto u:edge)
        if (getfa(u.x) != getfa(u.y))
        {
            ans += u.v;
            fa[getfa(u.x)] = getfa(u.y);
        }
    printf("%lld\n", ans);
    return 0;
}