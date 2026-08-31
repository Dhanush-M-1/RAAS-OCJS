#include <bits/stdc++.h>

using namespace std;

const int Nmax = 1e5 + 5;
int X, n, a[Nmax], mode, tmp, t, A, B, C, init, i, q;

void advance(int x)
{
    if(mode == -1)
    {
        int t = A + C;
        C -= x;
        if(t <= x) A += x-t;
    }
    else
    {
        int t = X - (B + C);
        C += x;
        if(t <= x) B -= x-t;
    }

    if(A > B)
    {
        if(mode == 1) A = B = X, C = 0;
            else A = B = 0, C = 0;
    }
}

int f(int x)
{
    if(x <= A) return A + C;
    if(x >= B) return B + C;
    return x + C;
}

int main()
{
   // freopen("input", "r", stdin);

    cin >> X >> n;
    for(i=1; i<=n; ++i) cin >> a[i];

    cin >> q; i = 1; A = 0, B = X, C = 0;
    tmp = 0; mode = -1;

    while(q--)
    {
        cin >> t >> init;
        while(i<=n && a[i] <= t)
        {
            advance(a[i] - tmp);
            mode = -mode; tmp = a[i++];
        }

        advance(t - tmp); tmp = t;
        cout << f(init) << '\n';
    }

    return 0;
}
