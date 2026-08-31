#include <iostream>
#include <bits/stdc++.h>

#define IOS                  \
    ios::sync_with_stdio(0); \
    cin.tie(0);              \
    cout.tie(0);
#define endl "\n"
#define int long long
#define all(a) a.begin(), a.end()
#define forn(i, N) for (int i = 0; i < N; i++)
#define forab(i, a, b) for (int i = a; i < b; i++)
#define print(x)          \
    for (auto i : x)      \
        cout << i << ' '; \
    cout << endl;
using namespace std;
int N, i, T, M, a, b, c, d;
int give_time(int val, vector<int> &max_A)
{
    return lower_bound(all(max_A), val) - max_A.begin();
}
int give_time(int val, int sigma, int mx, vector<int> &A, vector<int> &max_A)
{
    if (sigma <= 0)
    {
        if (val > mx)
            return -1;
        return give_time(val, max_A);
    }
    int n;
    if (val <= mx)
        n = 0;
    else
        n = ceil(double((val - mx)) / double(sigma));
    val -= n * sigma;
    return give_time(val, max_A) + n * A.size();
}
void solve()
{
    cin >> N >> M;
    vector<int> A(N);
    vector<int> X(M);
    vector<int> max_A(N);
    for (int &i : A)
        cin >> i;
    for (int &i : X)
        cin >> i;
    int sig = 0;
    int mx = INT_MIN;
    int index = 0;
    for (int i : A)
    {
        sig += i;
        mx = max(mx, sig);
        max_A[index++] = mx;
    }
    for (int i : X)
    {
        cout << give_time(i, sig, mx, A, max_A) << " ";
    }
    cout << endl;
}
int32_t main()
{
    IOS;
    cin >> T;
    while (T--)
        solve();
    return 0;
}