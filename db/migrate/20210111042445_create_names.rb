class CreateNames < ActiveRecord::Migration[6.0]
  def change
    create_table :names do |t|
      t.string :city
      t.string :conference
      t.string :gameID

      t.timestamps
    end
  end
end
