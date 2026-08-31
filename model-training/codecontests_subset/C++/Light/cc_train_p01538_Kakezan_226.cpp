#include <iostream>
#include <string>
using namespace std;

int main(){
    int Q;
    cin>>Q;
    string now;
    for(int i=0;i<Q;i++){
        cin>>now;
        int ans=0;
        for(;;){
            if(now.size()==1) break;
            int ma=0;
            for(int j=1;j<now.size();j++){
                ma=max(ma,stoi(now.substr(0,j))*stoi(now.substr(j,now.size()-j)));
            }
            now=to_string(ma);
            ans++;
        }
        cout<<ans<<endl;
    }
}