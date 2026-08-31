#include <bits/stdc++.h>
using namespace std;
int main(){
    vector<int> list;
    int x,n,i,s,sum;
    while(1){
        cin >> n;
        if(n==0){break;}
        for(i=0;i<n;i++){
            cin >> x; 
            list.push_back(x);
        }
        sum=0;
        i=0;
        for(int j=0; j<list.size()-1; j++){
        for(i=0; i<list.size()-1; i++){
            if(list[i]>list[i+1]){
                s=list[i];
                list[i]=list[i+1];
                list[i+1]=s;
                sum++;
            }
        }
        }
        cout << sum << endl;
        list.clear();
    }
}