#include <bits/stdc++.h>
using namespace std;

using ll = long long;
using pii = pair<int, int>;

template <typename T> constexpr T inf;
template <> constexpr int inf<int> = 1e9;
template <> constexpr ll inf<ll> = 1e18;
template <> constexpr double inf<double> = 1e18;

int main() {
    int N;
    cin >> N;
    vector<int> a(N);
    for(int i = 0; i < N; ++i) {
        cin >> a[i];
    }
    for(int i = 0; i < N; ++i) {
        for(int j = i + 1; j < N; ++j) {
            if(abs(a[i] - a[j]) % (N - 1) == 0) {
                cout << a[i] << ' ' << a[j] << endl;
                return 0;
            }
        }
    }
}
