#include<iostream>
#include<string>
#include<vector>
using namespace std;

int s[]={5,7,5,7,7};

int main(){
    int n;
    while(cin>>n&&n!=0){
        vector<int> w(n);
        string tmp;
        for(int i=0;i<n;i++){
            cin >> tmp;
            w[i] = tmp.size();
        }
        for(int i=0;i<n;i++){
            int x=0;
            int y=0;
            for(int j=i;j<n;j++){
                x += w[j];
                if(x==s[y]){
                    if(y==4){
                        cout << i+1 << endl;
                        goto lll;
                    }
                    x = 0;
                    y++;
                }else if(x>s[y]){
                    break;
                }
            }
        }
        lll:;
    }
    return 0;
}
