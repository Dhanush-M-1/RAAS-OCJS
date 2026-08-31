#include <iostream>
using namespace std;

const int step[5] = {5, 7, 5, 7, 7};

int N;
string S[40];

int solve() {
    for (int i = 0; i < N; ++i) {
        bool ok = true;
        int idx = i;
        for (int t = 0; t < 5; ++t) {
            int acc = 0;
            while (acc < step[t]) acc += S[idx++].size();
            if (acc != step[t]) {
                ok = false;
                break;
            }
        }
        if (ok)
            return i+1;
    }

    return -1;
}

int main(void) {
    while (true) {
        cin >> N;
        if (N == 0) break;
        for (int i = 0; i < N; ++i)
            cin >> S[i];

        cout << solve() << endl;
    }
    return 0;
}

