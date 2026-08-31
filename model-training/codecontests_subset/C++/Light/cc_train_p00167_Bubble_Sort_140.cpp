#include <iostream>
#include <vector>

using namespace std;

int bubble(vector<int> &vec,int to,int changes){
    if(to==0) return changes;
    for(int i=0;i<to;i++){
        if(vec[i] > vec[i+1]){
            int tmp = vec[i];
            vec[i] = vec[i+1];
            vec[i+1] = tmp;
            changes++;
        }
    }
    return bubble(vec,to-1,changes);
}

int main(){
    int n = 0;
    while(cin >> n && n != 0){
        vector<int> vec;
        for(int i=0;i<n;i++){
            int x;
            cin >> x;
            vec.push_back(x);
        }
        cout << bubble(vec,vec.size()-1,0) << endl;
    }
    return 0;
}