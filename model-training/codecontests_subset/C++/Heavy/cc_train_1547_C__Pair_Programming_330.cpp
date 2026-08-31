#include <iostream>
#include <queue>

using namespace std;

int main() {
    unsigned int t, k, n, m, x;
    cin >> t;

    for (unsigned int i = 0; i < t; i++) {
        cin >> k >> n >> m;
        queue<int> a;
        queue<int> b;
        queue<int> res;

        for (unsigned int j = 0; j < n; j++) {
            cin >> x;
            a.push(x);
        }

        for (unsigned int j = 0; j < m; j++) {
            cin >> x;
            b.push(x);
        }

        while (!a.empty() || !b.empty()) {
            unsigned int a_ = a.front(), b_ = b.front();
            if (a.empty()) a_ = -1;
            if (b.empty()) b_ = -1;
            if (a_ > k && b_ > k) break;
            if (a_ <= k && a_ >= 0) {
                res.push(a_);
                a.pop();
                if (a_ == 0) k++;
            }
            if (b_ <= k && b_ >= 0) {
                res.push(b_);
                b.pop();
                if (b_ == 0) k++;
            }
        }

        if (res.size() < n + m) cout << -1 << endl;
        else {
            while (res.size() > 0) {
                cout << res.front() << ' ';
                res.pop();
            }
            cout << endl;
        }
    }
    return 0;
}
