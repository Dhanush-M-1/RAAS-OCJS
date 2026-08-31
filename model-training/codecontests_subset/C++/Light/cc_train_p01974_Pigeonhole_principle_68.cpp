#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
int N;
vector<int> v;
int main(){
    cin >> N;
    for(int i=0; i<N; ++i){
        int a; cin >> a;
        v.push_back(a);
    }
    bool flag = true;
    for(int i=0; i<N; ++i){
        for(int j=0; j<N; ++j){
            if(!flag) break;
            
            if((abs(v[i]-v[j]))%(N-1)==0&&i!=j){
                cout << v[i] << " " << v[j] << endl;
                flag = false;
            }   
        }
        
    }

    return 0;
}
