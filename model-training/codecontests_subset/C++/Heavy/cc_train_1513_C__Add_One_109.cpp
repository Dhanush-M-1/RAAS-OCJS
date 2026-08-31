#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm> // for copy
#include <iterator>  // for ostream_iterator
using namespace std;

const int P = 1000000007;
const int M = 200000;
int answer_for_0[M+10];
// the result for the digit 0 is answer_for_0[m]
// the result for any other digit d is answer_for_0[m+d]

int main (){
    for (int i=0;i<10;i++)
        answer_for_0[i] = 1;
    
    for (int i=10; i<M+10; i++)
        answer_for_0[i] = (answer_for_0[i-10] + answer_for_0[i-9])%P;
    
    int t;
    cin >> t;
    vector<int> answers (t);

    for (int i=0; i<t; i++){
        int n, m;
        cin >>n >>m;
        int ans = 0;
        while(n > 0){
            ans = (ans+ answer_for_0[m+ n%10] )%P ;
            n/=10;
        }
        answers[i] = ans;
    }
    copy ( answers.begin(), answers.end(), ostream_iterator<int>(cout, "\n") );
    return 0;
}
