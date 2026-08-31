#include<iostream>
#include<bits/stdc++.h>

using namespace std;
//read domain
typedef long long ll;
int dp[200001][2];
void build(int l, int r, vector<int> const &a, vector<int> &d, int curD = 0) {
    if (r < l) {
        return;
    }
    if (l == r) {
        d[l] = curD;
        return;
    }
    int m = l;
    for (int i = l + 1; i <= r; i++) {
        if (a[m] < a[i]) {
            m = i;
        }
    }
    d[m] = curD;
    build(l, m - 1, a, d, curD + 1);
    build(m + 1, r, a, d, curD + 1);
}

int32_t main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
#ifndef ONLINE_JUDGE
    // cout << "hh" << endl;
    freopen("new_inp2.txt", "r", stdin);
    freopen("okk.txt", "w", stdout);
#endif
    ll chk[10001];

    int t;
    cin >> t;
    while (t--)
    {   //cout << "yes" << endl;
        ll n, m;
        cin >> n >> m;

        set<pair<ll, ll>> st;
        vector<ll> vect;
        ll sum = 0, mxx = INT_MIN;
        for (int i = 0; i < n; i++)
        {
            int x;
            cin >> x;
            vect.push_back(x);
            sum += x;
            if (mxx < sum)
            {
                mxx = sum;
                st.insert({sum, i});
                // cout << sum << " " << i << endl;

            }
        }
        // for (auto i : vect)
        // {
        //     cout << i << " ";
        // }
        // cout << endl;
        //cout << "yo" << endl;
        while (m--)
        {
            ll x;
            cin >> x;
            // cout << st.size() << "I am" << x << endl;
            ll round = 0;
            if (sum <= 0 && st.rbegin()->first < x)
            {
                cout << "-1" << " ";
                continue;
            }

            if (mxx < x)
            {
                ll temp = x - mxx;
                round = temp / sum + (temp % sum == 0 ? 0 : 1);
                x -= round * sum;
            }

            auto index = st.lower_bound({x, -1});
            //cout << round << "dd" << x << " " << index->second << endl;
            cout << index->second + round*n << " ";
        }
        cout << endl;
    }


}

