#include <iostream>
#include <string>
#include <vector>

using namespace std;

typedef short T;
const int MOD = 10000;

bool even_is_up;
inline bool up_turn(int col) {
    bool even = (col & 1) == 0;
    return even_is_up ? even : !even;
}

// テ・ツ青?、ツスツ催」ツ?ョ M テ」ツ?ォテ」ツつ暗」ツつ?MODテッツシツ?
// mod_of[0]テ」ツ??テ」ツ?ョテ、ツスツ催ッツシツ稽od_of[1]テ」ツ??0テ」ツ?ョテ、ツスツ催「ツ?ヲテ「ツ?ヲ
int mod_of[501];
int M;

// memo[high_limited][low_limited][prev_digit][column][acc]
T memo[2][2][16][512][500];
vector<int> low_digits, high_digits;
int dfs(int col, int high_limited, int low_limited, int prev, int acc) {
    if(col == -1) return acc == 0;
    bool first_digit = (prev < 0 || prev >= 10);
    T dmy = -1;
    T &res =  first_digit ? dmy : memo[high_limited][low_limited][prev][col][acc];
    //cout << "come " << col << ' ' << prev << ' ' << acc << ": res = " << res << endl;
    if(res < 0) {
        res = 0;
        int low = low_limited ? low_digits[col] : 0;
        int high = high_limited ? high_digits[col] : 9;
        if(first_digit) low = max(low, 1);
        if(up_turn(col)) {
            low = max(low, prev+1);
        } else {
            high = min(high, prev-1);
        }
        for(int digit = low; digit <= high; ++digit) {
            int next_hl = high_limited && (digit == high_digits[col]);
            int next_ll = low_limited && (digit == low_digits[col]);
            //cout << col << ' ' << high_limited << ' ' << low_limited << ' ' << acc << ": choose " << digit << endl;
            res += dfs(col-1, next_hl, next_ll, digit, (acc+mod_of[col]*digit) % M);
            res %= MOD;
        }
    }
    return res;
}

void clear_memo() {
    const int nelems = sizeof(memo) / sizeof(T);
    fill_n((T*)memo, nelems, -1);
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    string A, B;
    cin >> A >> B >> M;

    mod_of[0] = 1 % M;
    for(int i = 1; i <= 500; ++i) {
        mod_of[i] = (mod_of[i-1]*10) % M;
    }
    for(string::reverse_iterator it = A.rbegin(); it != A.rend(); ++it) {
        low_digits.push_back(*it - '0');
    }
    for(string::reverse_iterator it = B.rbegin(); it != B.rend(); ++it) {
        high_digits.push_back(*it - '0');
    }
    for(int i = 0; i < (int)B.size()-(int)A.size(); ++i) {
        low_digits.push_back(0); // sentinel
    }
    const int low_ord = (int)A.size()-1;
    const int high_ord = (int)B.size()-1;
    int res = 0;
    for(int step = 0; step < 2; ++step) {
        //cout << "step " << step << endl;
        even_is_up = (step == 0);
        clear_memo();
        for(int col = high_ord; col >= low_ord; --col) {
            if(col == 0 && step == 1) break; // 1テヲツ。ツ?」ツ?ョテヲツ閉ーテ」ツ?ョテ、ツコツ古ゥツ?催」ツつォテ」ツつヲテ」ツδウテ」ツδ暗ゥツ伉イテヲツュツ「
            bool low_limited = (col == low_ord);
            bool high_limited = (col == high_ord);
            int prev = up_turn(col) ? -1 : 10;
            res += dfs(col, high_limited, low_limited, prev, 0);
            res %= MOD;
        }
    }
    cout << res << endl;
    return 0;
}