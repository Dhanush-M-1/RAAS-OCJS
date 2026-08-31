#include<bits/stdc++.h>
using namespace std;

using i64 = int64_t;

int main(){
    int n;
    cin >> n;
    vector<int> v;
    for(int i=0;i<n;++i){
        int a;
        cin >> a;
        v.push_back(a);
    }

    for(int i=0;i<n;++i){
        for(int j=i+1;j<n;++j){
            if(abs(v[i]-v[j])%(n-1) == 0){
                cout << v[i] << " " << v[j] << endl;
                return 0;
            }
        }
    }

    return 0;
}

