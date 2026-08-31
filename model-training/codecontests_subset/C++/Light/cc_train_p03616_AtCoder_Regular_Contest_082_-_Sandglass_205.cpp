#include <bits/stdc++.h>
using namespace std;
#define LL long long
int X;
int n, q;
const int N = 200000;
int ri[N];
struct P3
{
    LL a, b, c;
} L[N];
P3 change(P3 a, int d)
{
    if (d <= 0)
    {
        if (a.c + d >= 0) return (P3){a.a, a.b, a.c + d};
        else if (a.c + a.b + d >= 0) return (P3){a.a + (-d) - a.c, a.b + a.a - (a.a + (-d) - a.c), 0};
        else return (P3){X, 0, 0};
    }
    else
    {
        if (a.c + a.b + d <= X) return (P3){a.a, a.b, a.c + d};
        else if (a.c + d <= X) return (P3){a.a, X - d - a.c, a.c + d};
        else return (P3){X, 0, X};
    }
}
int main()
{
    cin >> X >> n;
    L[0] = (P3){0, X, 0};
    for (int i = 1; i <= n; ++ i)
    {
        cin >> ri[i];
        if (i & 1) L[i] = change(L[i - 1], -(ri[i] - ri[i - 1]));
        else L[i] = change(L[i - 1], ri[i] - ri[i - 1]);
    }
    cin >> q;
    while (q --)
    {
        int t, a;
        cin >> t >> a;
        P3 nw;
        int p = upper_bound(ri, ri + n + 1, t) - ri - 1;
        if ((p + 1) & 1) nw = change(L[p], -(t - ri[p]));
        else nw = change(L[p], t - ri[p]);
        if (a <= nw.a) cout << nw.c;
        else if (a <= nw.a + nw.b) cout << nw.c + (a - nw.a);
        else cout << nw.c + nw.b;
        cout << endl;
    }
}