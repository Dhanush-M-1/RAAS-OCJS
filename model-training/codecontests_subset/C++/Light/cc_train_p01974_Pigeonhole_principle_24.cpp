#include <bits/stdc++.h>
using namespace std;

int main(){
    cin.tie(nullptr);
    ios::sync_with_stdio(false);

    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++){
        cin >> A[i];
    }

    sort(A.begin(), A.end());

    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if((A[j] - A[i]) % (n - 1) == 0){
                cout << A[i] << ' ' << A[j] << endl;
                return 0;
            }
        }
    }


    return 0;
}
