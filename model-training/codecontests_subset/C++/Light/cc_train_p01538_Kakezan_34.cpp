#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    for (int i = 0; i < n; ++i) {
        string s; cin >> s;
        int c = 0;
        while (s.length() >= 2) {
            int vm = -1;
            for (int j = 1; j < s.length(); ++j) {
                int t1 = atoi(s.substr(0, j).c_str());
                int t2 = atoi(s.substr(j, s.length()-j).c_str());
                vm = max(vm, t1*t2);
            }
            ++c;
            s = to_string(vm);
        }
        cout << c << endl;
    }
}