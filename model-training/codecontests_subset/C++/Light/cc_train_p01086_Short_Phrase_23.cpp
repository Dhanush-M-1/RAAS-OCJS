#include <bits/stdc++.h>

using namespace std;

const vector<int> num = {5, 7, 5, 7, 7};

bool Check(int idx, const int n, const vector<int> &w) {
    int j = 0, sum = 0;
    for (int i = idx; i < n && j < 5; ++i) {
        sum += w[i];
        if (num[j] == sum) {
            ++j;
            sum = 0;
        }
        else if (num[j] < sum)
            return true;
    }

    return (j == 5) ? false : true;
}

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(false);

    int n;
    string s;

    while (cin >> n, n) {
        vector<int> w(n);
        for (int i = 0; i < n; ++i) {
            cin >> s;
            w[i] = s.size();
        }

        int idx = 0;
        while (Check(idx, n, w))
            ++idx;

        cout << idx + 1 << endl;
    }

    return 0;
}