#include <iostream>
using namespace std;

int solve(int n) {
    int d, next_n;

    int count = 0;

    while(n >= 10) {
        ++count;
        d = 1000000;
        next_n = 0;

        while(d > 0) {
            next_n = max(next_n, (n / d) * (n % d));
            d /= 10;
        }

        n = next_n;
    }

    return count;
}

int main() {
    int Q, N;
    cin >> Q;
    for(int i = 0; i < Q; ++i) {
        cin >> N;
        cout << solve(N) << endl;
    }
    return 0;
}