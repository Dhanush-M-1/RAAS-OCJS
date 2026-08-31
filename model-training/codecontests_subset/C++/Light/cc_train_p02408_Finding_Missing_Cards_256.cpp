#include <bits/stdc++.h>
using namespace std;
vector<char> s{'S', 'H', 'C', 'D'};
map<pair<char, int>, int> m;

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        char c;
        int x;
        cin >> c >> x;
        m[make_pair(c, x)] = 1;
    }
    for (auto& c: s) {
        for (int i = 1; i <= 13; i++) {
            if (m[make_pair(c, i)] == 0) cout << c << " " << i << endl;
        }
    }
}
