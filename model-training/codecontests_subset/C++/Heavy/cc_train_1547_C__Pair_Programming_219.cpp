//g++ run.cpp -o run & run
#include <bits/stdc++.h>
using namespace std;
#define ll long long int

void test();
void preprocessing();
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    ll t;
    cin >> t;
    while (t--)
    {
        test();
        cout << endl;
    }
    return 0;
}
void preprocessing()
{
    return;
}
void test()
{
    int k, n, m;
    cin >> k >> n >> m;

    int a[n];
    int b[m];

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    for (int j = 0; j < m; j++)
    {
        cin >> b[j];
    }

    int i = 0;
    int j = 0;
    vector<int> ans;
    while (i < n && j < m)
    {
        if (a[i] <= k && a[i] != 0)
        {
            ans.push_back(a[i]);
            i++;
        }
        else if (a[i] == 0)
        {
            ans.push_back(a[i]);
            k++;
            i++;
        }
        else if (b[j] <= k && b[j] != 0)
        {
            ans.push_back(b[j]);
            j++;
        }
        else if (b[j] == 0)
        {
            ans.push_back(b[j]);
            j++;
            k++;
        }
        else
        {
            // cout << "k = " << k << " i = " << i << " j = " << j << endl;
            cout << "-1";
            return;
        }
    }

    while (i < n)
    {
        if (a[i] > k)
        {
            cout << "-1" << endl;
            return;
        }
        if (a[i] == 0)
            k++;
        ans.push_back(a[i]);
        i++;
    }

    while (j < m)
    {
        if (b[j] > k)
        {
            cout << "-1" << endl;
            return;
        }
        if (b[j] == 0)
            k++;
        ans.push_back(b[j]);
        j++;
    }

    for (int x : ans)
    {
        cout << x << " ";
    }
    return;
}