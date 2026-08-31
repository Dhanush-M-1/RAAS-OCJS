#include <iostream>
#include <algorithm>

using namespace std;

int Q;
int N;

int solve(int n) {
    if (0 <= n && n <= 9) return 0;
    int max_n = 0;
    for (int i = 10; i <= n; i *= 10) {
        int a = n / i;
        int b = n % i;
        max_n = max(max_n, a*b);
    }
    return solve(max_n) + 1;
}

int main() {
    cin >> Q;
    for (int i = 0; i < Q; i++) {
        cin >> N;
        cout << solve(N) << endl;
    }
    return 0;
}